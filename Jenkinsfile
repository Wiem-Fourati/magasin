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
        		sh 'docker build . -t magasin-image'
        	}
        }
        stage('deploy') {
        	steps {
        		sh 'ansible-playbook deploy-ansible.yml -i hosts.yml'
        	}
        }
    }
}
