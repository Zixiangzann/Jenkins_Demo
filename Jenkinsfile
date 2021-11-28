pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "m2"
    }
    stages {
        
        stage('Preparation') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main',
                url: 'https://github.com/Zixiangzann/Jenkins_Demo.git'
            }
        }
            
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                //sh "mvn clean test"
                // To run Maven on a Windows agent, use
                  bat "mvn clean test"
            }
        }
    }
}