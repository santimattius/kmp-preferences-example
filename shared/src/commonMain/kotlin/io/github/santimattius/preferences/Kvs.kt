package io.github.santimattius.preferences

class Kvs(definition: KvsDefinition) : KeyValueStorage by createKvs(definition)