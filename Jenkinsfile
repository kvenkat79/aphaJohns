pipeline{

    agent any

    stages {
        stage ('Mvn Stage') {

            steps {
               bat '''set PATH=%PATH%;C:\\Maven\\apache-maven-3.6.0\\bin'''
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

