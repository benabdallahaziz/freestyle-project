pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "azizbenabdallah/spring-app"
        DOCKER_TAG = "1.0"
        NAMESPACE = "devops"
    }

    stages {
        stage('Git Checkout') {
            steps {
                echo 'Code already checked out'
            }
        }

        stage('Build') {
            steps {
                dir('/home/vagrant/Projet-devops') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Docker Build & Push') {
            steps {
                dir('/home/vagrant/Projet-devops') {
                    sh 'docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .'
                    sh 'docker push ${DOCKER_IMAGE}:${DOCKER_TAG}'
                }
            }
        }

        stage('Kubernetes Deploy') {
            steps {
                sh 'kubectl apply -f /home/vagrant/mysql-deployment.yaml'
                sh 'kubectl apply -f /home/vagrant/spring-deployment.yaml'
            }
        }

        stage('Deploy MySQL & Spring Boot on K8s') {
            steps {
                sh 'kubectl rollout restart deployment/spring-app -n ${NAMESPACE}'
                sh 'kubectl rollout status deployment/spring-app -n ${NAMESPACE} --timeout=120s'
            }
        }
    }

    post {
        success {
            echo '✅ Déploiement réussi !'
        }
        failure {
            echo '❌ Échec du pipeline !'
        }
    }
}
