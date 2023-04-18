pipeline
{
agent any
	tools {
		maven "maven"
	       }
	stages
	{
		stage('maven build')
		{
			steps
			{
				git branch: 'main', url: 'https://github.com/shiva466/NutriApp.git'
				withMaven(maven:'maven')
				{
					bat "mvn test"
				}
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
