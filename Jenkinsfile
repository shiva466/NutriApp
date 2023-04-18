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
				withMaven(maven:'maven')
				{
					bat "mvn sonar:sonar"
				}
			}
		}
	} 
}
