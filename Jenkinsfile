
/* variables */

pipeline {
    agent any
   
    stages {
        
        stage('Downloading code') { 
            steps {
                echo 'Downloading code...'
                echo 'Updating code...'
                sh 'git fetch && git pull'
            }
        }
        stage('Build') { 
            steps {
                echo 'Building code...'
                sh 'mvn build -DskipTests'
                echo 'Build'
            }
        }
        stage('Test') { 
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }
    }
}
