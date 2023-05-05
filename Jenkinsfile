pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices:['1.1.0', '1.2.0', '1.3.0'] , description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')

    }
 //   environment {

 //       SERVER_CREDENTIALS = credentials('agent-credentials')
  //  }

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {
           when {
             expression {
                params.executeTests = true
             }
           }
           steps {
              withMaven(maven : 'maven_3_6_3') {
                echo " this should be done to ${params.executeTests}"
                sh 'mvn test'
              }
           }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'maven_3_6_3') {
//                    sh 'mvn deploy'
                      echo "Deploy complete ${params.VERSION}"
                }
            }
        }
    }

}