package net.nomia.pos.ui.auth.pos_setup.mvi


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import net.nomia.mvi.MviBootstrap
import net.nomia.pos.ui.auth.pos_setup.domain.OrganizationsUseCase
import net.nomia.pos.ui.auth.pos_setup.domain.ServerProviderUseCase

internal class PosSetupMviBootstrap(
    private val organizationUseCase: OrganizationsUseCase,
    private val serverProviderUseCase: ServerProviderUseCase,
) : MviBootstrap<PosSetupMviEffect> {

    override fun invoke(): Flow<PosSetupMviEffect> = merge(
        organizationUseCase
            .observe()
            .map { PosSetupMviEffect.SetOrganizations(it) },
        serverProviderUseCase
            .get()
            .map { PosSetupMviEffect.SetServerProvider(it) },
    )


}
