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
				withMaven(maven:'MVN_HOME')
				{
					bat "mvn sonar:sonar"
				}
			}
		}
	} 
}
