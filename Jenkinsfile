pipeline {
    agent any
    environment {
        BRANCH_NAME == 'main'
        SERVER_CREDENTIALS = credentials('agent-credentials')
    }

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {
                when{
                    expression{
                        BRANCH_NAME == 'main'
                    }
                }
                steps {
                    withMaven(maven : 'maven_3_6_3') {
                        sh 'mvn test'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn deploy'
                }
            }
        }
    }

}