# Graalvm Annotations

Java Annotations for generating Graalvm ReflectionConfigurationFiles (https://github.com/oracle/graal/blob/master/substratevm/Reflection.md).

Can be used in combination with [Gradle Graalvm Annotation Processor](https://github.com/formkiq/graalvm-annotations-processor).

|Annotation|Description|
|--------------|--------------------------|
| @Reflectable |  Can be  applied to a class add the class to Graalvm's list of reflection classes to process, (based on https://github.com/oracle/graal/blob/master/substratevm/Reflection.md). |
| @ReflectableClass | Manually configure Graalvm reflection class (based on https://github.com/oracle/graal/blob/master/substratevm/Reflection.md). Can be used on any class you cannot apply the @Reflectable annotation to. |
@ReflectableClasses | List of ReflectableClass definitions. |
@ReflectableField | Used with @ReflectableClass to define Graalvm reflection for a class field. |
@ReflectableMethod | Used with @ReflectableClass to define Graalvm reflection for a class method. |
@ReflectableImport | Import existing Graalvm 'ReflectionConfigurationFiles' File. |

## Maven Installation
Add the following to your pom.xml

```xml
    <dependency>
        <groupId>com.formkiq</groupId>
        <artifactId>graalvm-annotations</artifactId>
        <version>VERSION</version>
        <!-- Replace VERSION with the version you want to use -->
    </dependency>
```

## Gradle Installation

Add the following to your build.gradle

```
   implementation group: 'com.formkiq', name: 'graalvm-annotations', version:'VERSION'
   <!-- Replace VERSION with the version you want to use -->
```

## @Reflectable Example

### TestObject.java
<pre>
@Reflectable
class TestObject {

  /** Preset Key. */
  @Reflectable
  private String id;
}
</pre>

## @ReflectableClasses / @ReflectableClass Example
### TestObject.java
<pre>
class TestObject {
  private String foo;
  public void bar(String s) {}
}
</pre>

### Test.java
<pre>
@ReflectableClasses({
  @ReflectableClass(
    className=TestObject.class,
    allDeclaredConstructors=false,
    fields = {@ReflectableField(allowWrite = true, name = "foo")},
    methods = {@ReflectableMethod(name = "bar", parameterTypes = {"java.lang.String"})}
  )
})
class Test { }
</pre>

## @ReflectableImport classes Example

### Test.java
<pre>
@Reflectable
class TestObject {
  /** Preset Key. */
  @Reflectable
  private String id;
}
</pre>
<pre>
@ReflectableImport(classes = {TestObject.class})
class Test { }
</pre>

## @ReflectableImport file Example

### test.json
<pre>
[
  {
    "name": "sample.Test",
    "allDeclaredConstructors": true,
    "allPublicConstructors": true,
    "allDeclaredMethods": true,
    "allPublicMethods": true,
    "fields": [
      {
        "name": "foo"
      }
    ],
    "methods": [
      {
        "name": "bar",
        "parameterTypes": [
          "int"
        ]
      }
    ]
  }
]
}
</pre>

### Test.java
<pre>
@ReflectableImport(files="test.json")
class Test { }
</pre>
