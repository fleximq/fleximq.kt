package io.github.fleximq.transport

import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

public interface Transport<in Input, out Output> {
    public val sendChannel: SendChannel<Input>
    public val receiveFlow: Flow<Output>
    public fun start()
}

public interface SharedTransport<in Input, out Output> : Transport<Input, Output> {
    public override val receiveFlow: SharedFlow<Output>
}