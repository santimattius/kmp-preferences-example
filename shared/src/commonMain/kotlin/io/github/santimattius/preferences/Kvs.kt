package io.github.santimattius.preferences

class Kvs(definition: KvsDefinition) : KvsReader by createKvs(definition)