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
					bat "mvn -Dmaven.test.skip=true install"
				}
			}
			post
			{
				success
				{
					junit '*/target/surefire-reports/TEST-.xml'
					archieveArtifacts 'target/*.jar'
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
