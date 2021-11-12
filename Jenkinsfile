pipeline {
    agent any
    
    /* variables */
    def repo = 'https://github.com/Fiordy/herokube-kotlin.git'
    stages {
        
        
        stage('Downloading code') { 
            steps {
                echo 'Downloading code...'
                sh 'git clone ${repo}'
                echo 'Downloaded'
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
