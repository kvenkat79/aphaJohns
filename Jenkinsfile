pipeline{

    agent any
    environment {
        application = 'mot'
        applicationType    = 'external'
    }

    stages {
        stage ('Mvn Stage') {

            steps {
               set PATH=%PATH%;C:\\Maven\\apache-maven-3.6.0\\bin,
               set PATH=%PATH%;C:\\Windows\\system32 
            }
        }
        stage ('Compile Stage') {

            steps {

                withMaven(maven: 'maven-3.6.0') {
                    sh 'mvn clean install'

                }

            }
        }
    stage ('Test Stage') {

            steps {

                echo 'test success'

            }
        }

    }

}

