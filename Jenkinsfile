pipeline
{
agent any
	tools {
		maven "maven"
	       }
	stages
	{
		stage('Build') 
		{
           	 steps 
			{
                	sh 'mvn clean package'
            		}
        	}
		
		stage('Mock Test') {
            steps {
                sh 'mvn test -Dtest=ait.student.nutrition'
            }
        }
		
		 stage('Deploy') {
            steps {
                sh 'mvn deploy'
            }
        }

		stage('scan pages')
		{
			steps
			{
				 withSonarQubeEnv('nutrisonar')
				{
				withMaven(maven:'maven')
				{
					bat "mvn sonar:sonar"
				}
				}
			}
		}
		
	} 
}
