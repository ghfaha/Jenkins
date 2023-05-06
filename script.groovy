def buildApp() {
    withMaven(maven : 'maven_3_6_3') {
        sh 'mvn clean compile'
    }
    echo "The build stage has been successfuly finished"
}

def testApp(){
    withMaven(maven : 'maven_3_6_3') {
        sh 'mvn test'
    }
    echo "The test stage has been successfuly finished"
}

def deployApp() {
        echo "The deploy stage has been successfuly finished"
        echo "Deploy complete ${params.VERSION}"  
}
return this

