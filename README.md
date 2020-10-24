# Graalvm Annotations

Java Annotations for generating Graalvm ReflectionConfigurationFiles (https://github.com/oracle/graal/blob/master/substratevm/Reflection.md).

Can be used in combination with [Gradle Graalvm Annotation Processor](https://github.com/formkiq/graalvm-annotations-processor).

|Annotation|Description|
|--------------|--------------------------|
| @Reflectable |  Can be  applied to a class add the class to Graalvm's list of reflection classes to process, (based on https://github.com/oracle/graal/blob/master/substratevm/Reflection.md). |
| @ReflectableClass | Manually configure Graalvm reflection class (based on https://github.com/oracle/graal/blob/master/substratevm/Reflection.md). Can be used on any class you cannot apply the @Reflectable annotation to. |
@ReflectableClasses | List of ReflectableClass definitions. |
@ReflectableField | Used with @ReflectableClass to define Graalvm reflection for a class field. |
@ReflectableImport | Import existing Graalvm 'ReflectionConfigurationFiles' File. |
@ReflectableMethod | Used with @ReflectableClass to define Graalvm reflection for a class method. |
