
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
            }
        }
        stage('Containerize'){
            steps {
                echo 'Meaningless step'
            }   
        }
        stage('Flyway validation'){
            steps {
                echo 'Running Flyway validation...'
                sh './mvnw -Dflyway.configFiles=src/main/resources/application.yml flyway:validate'
            }
        }
    }
}
