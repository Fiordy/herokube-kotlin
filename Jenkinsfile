
/* variables */

pipeline {
    agent any
   
    stages {
        
        stage('Downloading code') { 
            steps {
                echo 'Downloading code...'
                try {
                    echo 'Updating code...'
                    sh 'git fetch && git pull'
                } catch (Exception e){
                    echo 'No previous repo, cloning...'
                    sh 'git clone https://github.com/Fiordy/herokube-kotlin.git
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
