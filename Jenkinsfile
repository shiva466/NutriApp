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
					bat "mvn clean install"
				}
			}
			post
			{
				success
				{
					junit 'target/surefire-reports/TEST-*.xml'
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
		stage('docker build')
		{
		      agent any
		      {
			      steps
			      {
				      bat 'docker build -t NutritionApp:latest .'
			      }
		      }
		}
		
	}
}
