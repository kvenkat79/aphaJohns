pipeline{
    agent{
      label 'master'
    }
    stages{
        stage('Compile stage'){
            steps{
                withmaven(maven: 'maven-3.6.0') {
                    sh 'maven clean compile'
                }
            }
        }

        stage('Testing stage'){
            steps{
                withmaven(maven: 'maven-3.6.0'){
                    sh 'mvn test'
                }
            }
        }
    }
}
