pipeline{

    agent any
    environment {
        application = 'general'
        applicationType    = 'wonder'
    }

    stages {
        stage ('Compile Stage') {

            steps {

                withMaven(maven: 'maven-3.6.0') {
                    sh 'mvn clean install'

                }

            }
        }
    stage ('Test Stage') {

            steps {

                   withMaven(maven: 'maven-3.6.0') {
                    sh 'mvn test'

                }

            }
        }

    }

}

