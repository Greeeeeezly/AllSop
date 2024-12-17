pipeline {
    agent any
    environment {
        // ИспользуйтеCredentialsID из Jenkins, а не прямой токен
        GIT_CREDENTIALS_ID = 'github-credentials'
        GIT_REPO_URL = 'https://github.com/Greeeeeezly/AllSop.git'
        BRANCH_NAME = 'master' 
    }
    stages {
        stage('Clone Repository') {
            steps {
                // Используйте credentials через Jenkins
                git branch: env.BRANCH_NAME, 
                    credentialsId: env.GIT_CREDENTIALS_ID, 
                    url: env.GIT_REPO_URL
            }
        }
        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean install'
            }
        }
        
        stage('Prepare docker-compose') {
            steps {
                sh '''
                    curl -L "https://github.com/docker/compose/releases/download/v2.23.3/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
                    chmod +x /usr/local/bin/docker-compose
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh '''
                    docker-compose -f docker-compose.yml down || true
                    docker-compose -f docker-compose.yml up --build -d
                '''
            }
        }
    }
}