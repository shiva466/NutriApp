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
				withMaven(maven:'Maven_Home')
				{
					bat "mvn sonar:sonar -Dsonar.host=http://localhost:9000 -Dsonar.login=jenkins-sonar"
				}
			}
		}
	} 
}
