pipeline {
    agent any
    environment {
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
                    BRANCH_NAME =='dev' || BRANCH_NAME == 'main'
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