打开短点发现

ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry

this.reader.loadBeanDefinitions(configClasses);


ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsForBeanMethod




// Do we need to mark the bean as skipped by its condition?
		if (this.conditionEvaluator.shouldSkip(metadata, ConfigurationPhase.REGISTER_BEAN)) {
			configClass.skippedBeanMethods.add(methodName);
			return;
		}


ConditionEvaluator.shouldSkip

List<Condition> conditions = new ArrayList<>();
    for (String[] conditionClasses : getConditionClasses(metadata)) {
        for (String conditionClass : conditionClasses) {
            Condition condition = getCondition(conditionClass, this.context.getClassLoader());
            conditions.add(condition);
        }
    }

AnnotationAwareOrderComparator.sort(conditions);

for (Condition condition : conditions) {
    ConfigurationPhase requiredPhase = null;
    if (condition instanceof ConfigurationCondition) {
        requiredPhase = ((ConfigurationCondition) condition).getConfigurationPhase();
    }
    if ((requiredPhase == null || requiredPhase == phase) && !condition.matches(this.context, metadata)) {
        return true;
    }
}


SpringBootCondition.matches(ConditionContext context, AnnotatedTypeMetadata metadata)

String classOrMethodName = getClassOrMethodName(metadata);
    try {
        ConditionOutcome outcome = getMatchOutcome(context, metadata);
        logOutcome(classOrMethodName, outcome);
        recordEvaluation(context, classOrMethodName, outcome);
        return outcome.isMatch();
    }