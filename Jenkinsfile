def gv
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
        stage ("initialize") {
            steps {
                script {
                 gv = load "script.groovy"
                }
            }
        }
        stage ('Compile Stage') {

            steps {
                gv.buildApp()
                }
            }
        }

        stage ('Testing Stage') {
            when {
                expression {
                    params.executeTests == true
                }
           }
           steps {
               script {
                   gv.testApp()
               }
           }
        }


        stage ('Deployment Stage') {
            steps {
               script {
                   gv.deployApp()
               }

                }
            }
        }
    }

}