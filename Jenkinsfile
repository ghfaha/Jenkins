
pipeline {
    agent any
    environment {
        NEW_VERSION = ''
        SERVER_CREDENTIALS = credentials('agent-credentials')

    }

    stages {
        stage ('Compile Stage') {

            steps {
                echo "Building version ${NEW_VERSION}"
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {
                when{
                    expression{
                    BRANCH_NAME =='dev' || BRANCH_NAME == 'main'

                    }
                }
                steps {
                    withMaven(maven : 'maven_3_5_0') {
                        sh 'mvn test'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
            withCredentials([usernamePassword(credentials: 'agent-credentials', usernameVariable: USER, passwordVariable: PWD)])
                withMaven(maven : 'maven_3_5_0') {
                    echo "Deploy is in progress with ${USER} ${PWD}"
                    sh 'mvn deploy'
                }
            }
        }
    }

}