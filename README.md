<a href="https://opensource.newrelic.com/oss-category/#new-relic-experimental"><picture><source media="(prefers-color-scheme: dark)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/dark/Experimental.png"><source media="(prefers-color-scheme: light)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Experimental.png"><img alt="New Relic Open Source experimental project banner." src="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Experimental.png"></picture></a>


![GitHub forks](https://img.shields.io/github/forks/newrelic-experimental/newrelic-java-ktor?style=social)
![GitHub stars](https://img.shields.io/github/stars/newrelic-experimental/newrelic-java-ktor?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/newrelic-experimental/newrelic-java-ktor?style=social)

![GitHub all releases](https://img.shields.io/github/downloads/newrelic-experimental/newrelic-java-ktor/total)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/newrelic-experimental/newrelic-java-ktor)
![GitHub last commit](https://img.shields.io/github/last-commit/newrelic-experimental/newrelic-java-ktor)
![GitHub Release Date](https://img.shields.io/github/release-date/newrelic-experimental/newrelic-java-ktor)


![GitHub issues](https://img.shields.io/github/issues/newrelic-experimental/newrelic-java-ktor)
![GitHub issues closed](https://img.shields.io/github/issues-closed/newrelic-experimental/newrelic-java-ktor)
![GitHub pull requests](https://img.shields.io/github/issues-pr/newrelic-experimental/newrelic-java-ktor)
![GitHub pull requests closed](https://img.shields.io/github/issues-pr-closed/newrelic-experimental/newrelic-java-ktor)


# New Relic Java Instrumentation for Ktor

Provides instrumentation of both the client and server sides of Ktor.  This includes support for distributed tracing between the client and the server.

## Installation

It is recommended to also use the instrumentation for Kotlin Coroutines: https://github.com/newrelic/newrelic-java-kotlin-coroutines    
   
This use this instrumentation.   
1. Download the latest release.    
2. In the New Relic Java Agent directory (directory containing newrelic.jar), create a directory named extensions if it doe not already exist.   
3. Copy the jars into the extensions directory.   
4. Restart the application.   

## Getting Started

After deployment, you should get route names for your web transactions instead of the generic name provided by the agent.  
You should also see deeper visibiity into what is happening in your application via the enhanced transaction traces/distributed traces provided by this instrumentation.    
   
### Recommended Kotlin Coroutine Configuration   
Ktor intiates a long running lazy Coroutine that will dominate the transaction times for your application unless it is ignored.  Please use this version or later (https://github.com/newrelic/newrelic-java-kotlin-coroutines/releases/tag/v1.0.4) to enable this feature and  add io.ktor.server.netty.cio.RequestBodyHandler to the scopes elemeent in the Coroutines stanza in newrelic.yml as shown here: https://github.com/newrelic/newrelic-java-kotlin-coroutines?tab=readme-ov-file#configuring-scopes-to-ignore    
   
## Support

New Relic has open-sourced this project. This project is provided AS-IS WITHOUT WARRANTY OR DEDICATED SUPPORT. Issues and contributions should be reported to the project here on GitHub.

>We encourage you to bring your experiences and questions to the [Explorers Hub](https://discuss.newrelic.com) where our community members collaborate on solutions and new ideas.

## Contributing

We encourage your contributions to improve Salesforce Commerce Cloud for New Relic Browser! Keep in mind when you submit your pull request, you'll need to sign the CLA via the click-through using CLA-Assistant. You only have to sign the CLA one time per project. If you have any questions, or to execute our corporate CLA, required if your contribution is on behalf of a company, please drop us an email at opensource@newrelic.com.

**A note about vulnerabilities**

As noted in our [security policy](../../security/policy), New Relic is committed to the privacy and security of our customers and their data. We believe that providing coordinated disclosure by security researchers and engaging with the security community are important means to achieve our security goals.

If you believe you have found a security vulnerability in this project or any of New Relic's products or websites, we welcome and greatly appreciate you reporting it to New Relic through [HackerOne](https://hackerone.com/newrelic).

## License

New Relic Java Instrumentation for Ktor is licensed under the [Apache 2.0](http://apache.org/licenses/LICENSE-2.0.txt) License.

>[If applicable: [Project Name] also uses source code from third-party libraries. You can find full details on which libraries are used and the terms under which they are licensed in the third-party notices document.]
