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
        stage ('load') {
            steps {
                script {
                    gv = load "script.groovy"
                }
//                archiveArtifacts allowEmptyArchive: true, artifacts: '', fingerprint: true, followSymlinks: false, onlyIfSuccessful: true
            }
        }

        stage ('Compile Stage') {
            steps {
                script {
                    gv.buildApp()
                }
//                archiveArtifacts allowEmptyArchive: true, artifacts: '', fingerprint: true, followSymlinks: false, onlyIfSuccessful: true
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
//               archiveArtifacts allowEmptyArchive: true, artifacts: '', fingerprint: true, followSymlinks: false, onlyIfSuccessful: true
           }
        }

        stage ('Deployment Stage') {
            steps {
               input message: "confirm deployment to production",
                ok: "Deploy"
               script {
                   gv.deployApp()
               }

            }
        }
    }
}
