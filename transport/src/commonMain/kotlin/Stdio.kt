package io.github.fleximq.transport

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

public class StdioTransport(
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Default),
): Transport<String, String> {
    private val output = Channel<String>()
    public override val sendChannel: SendChannel<String> = output
    private val outputJob = coroutineScope.launch(start = CoroutineStart.LAZY) {
        while(currentCoroutineContext().isActive) {
            output.consumeEach {
                print(it)
            }
        }
    }
    private val input = Channel<String>()
    public override val receiveFlow: Flow<String> = input.consumeAsFlow()
    private val inputJob = coroutineScope.launch(start = CoroutineStart.LAZY) {
        while(currentCoroutineContext().isActive) {
            val line = readlnOrNull() ?: break
            input.send(line)
        }
    }
    override fun start() {
        outputJob.start()
        inputJob.start()
    }
}