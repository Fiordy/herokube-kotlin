
/* variables */

pipeline {
    agent any
   
    stages {
        
        stage('Update') { 
            steps {
                echo 'Downloading code...'
                echo 'Updating code...'
            }
        }
        stage('Build') { 
            steps {
                echo 'Building code...'
                sh './mvnw install -DskipTests'
                echo 'Build'
            }
        }
        stage('Test') { 
            steps {
                echo 'Running tests...'
                sh './mvnw test'
            }
        }
        stage('Containerize'){
            steps {
                echo 'Meaningless step'
            }   
        }
    }
}
