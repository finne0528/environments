package com.it_finne.environments

import com.it_finne.environments.constant.ApplicationState
import com.it_finne.environments.constant.EnvironmentStatus
import mu.KLogger
import mu.KotlinLogging

private const val ENVIRONMENT_NAME: String = "ENVIRONMENT"

private val logger: KLogger = KotlinLogging.logger {}

object Environments {
    val APPLICATION_ENVIRONMENT: EnvironmentStatus = EnvironmentStatus.values().find {
        it.name == System.getenv(ENVIRONMENT_NAME)
    } ?: let {
        logger.warn { "the environment was not configured. running in development mode. to specify the environment, configure the environment variable 'ENVIRONMENT'." }
        EnvironmentStatus.DEVELOPMENT
    }

    var APPLICATION_STATE: ApplicationState = ApplicationState.MAINTENANCE

    fun isMaintenance(): Boolean = this.APPLICATION_STATE == ApplicationState.MAINTENANCE
}
