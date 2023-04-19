pipeline
{
agent any
	tools {
		maven "maven"
	       }
	stages
	{
		stage('maven install and test')
		{
			steps
			{
				withMaven(maven:'maven')
				{
					bat "mvn -Dmaven.test.skip=true install"
				}
			}
			post
			{
				success
				{
					junit '*/target/surefire-reports/TEST-*.xml'
					archiveArtifacts 'target/*.jar'
				}
			}
		}
				
				
		
		stage('Sonar scan')
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
