pipeline {
agent any
	tools {
		maven "maven"
	}
	stages
	{
		stage('scan pages')
		{
			steps
			{
				 withSonarQubeEnv('nutrisonar') {
				withMaven(maven:'Maven_Home')
				{
					bat "mvn sonar:sonar"
				}
				 }
			}
		}
	} 
}
