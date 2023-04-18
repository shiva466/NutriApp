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
				withSonarQubeEnv(installationName: 'nutrisonar')
				{
					sh 'mvn clean sonar:sonar -Dsonar.host=http://localhost:9000 -Dsonar.login=jenkins-sonar'
				}
			}
		}
	} 
}
