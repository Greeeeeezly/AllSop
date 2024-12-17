pipeline {
    agent { docker { image 'maven:3.8.6-openjdk-17' } }

    environment {
        WORKSPACE_DIR = "${env.WORKSPACE}"
        PROJECT_DIR = "/AllSop"
        MAVEN_CACHE = "/tmp/.m2"
    }

    stages {
        stage('Checkout') {
            agent { label 'agent' }

            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'github-creds', usernameVariable: 'GITHUB_USER', passwordVariable: 'GITHUB_TOKEN')]) {
                        checkout([
                            $class: 'GitSCM',
                            branches: [[name: "*/master"]],
                            userRemoteConfigs: [[
                                url: 'https://github.com/Greeeeeezly/AllSop.git',
                                credentialsId: 'github-creds'
                            ]]
                        ])
                    }
                }
            }
        }

        stage('Build') {
            agent {
                docker {
                    image 'maven:3.8.6-openjdk-17'
                    args "-u root -v ${MAVEN_CACHE}:/root/.m2 -v ${WORKSPACE_DIR}:${PROJECT_DIR} --workdir=${PROJECT_DIR}"
                    reuseNode true
                }
            }

            steps {
                script {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

        stage('Deploy') {
            agent { label 'agent' }

            steps {
                script {
                    sh 'docker-compose up -d'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }

        failure {
            echo 'Pipeline failed.'
        }
    }
}
