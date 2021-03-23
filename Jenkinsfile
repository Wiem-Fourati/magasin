pipeline {
    agent any

    tools {
        maven "maven3"
    }

    stages {
          stage('Checkout changes') { 
		  steps {
			  checkout scm
		  }
   		
	  }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

            }
        }
        stage('create container') {
        	steps {
        		sh 'docker build . -t magasin:0.0.1'
        	}
        }
        stage('deploy') {
        	steps {
        		sh 'docker run -d -p 8888:8080 --name magasin magasin:0.0.1'
        	}
        }
    }
}
