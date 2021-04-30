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
        stage('compile jar file') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

            }
        }
        stage('build docker image') {
        	steps {
        		sh 'docker build . -t magasin-image'
			sh 'docker save -o magasin-image.tar magasin-image'
        	}
        }
        stage('deploy') {
        	steps {
        		sh 'docker-compose up -d'
			//ansible-playbook --vault-password-file /etc/ansible/vault-password-file deploy-ansible.yml -i hosts.yml -vvv
        	}
        }
    }
}
