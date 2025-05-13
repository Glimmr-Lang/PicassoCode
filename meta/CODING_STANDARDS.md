# Coding Standards

Below are a set of rule that are expected to be followed and adhered to when writing code for the PiccasoCode project. 
This is not to be an authoritarian but it is meant to allow your code to look like my code and mine to look like yours. 
This simple approach allows anyone to debug anything when it goes wrong because the code looks the same. This also allows
us to write the same file and maintain an common standard. 

### Rules. 
1. Keep it simple. Methods/Functions should only do 1 thing and do it very well.
E.g

Good practice:
```java
private void save(ActionEvent e) {
	....
}

private void compile(ActionEvent e) {
	....
}

private void saveAndCompile(ActionEvent e) {
	save(e);
	compile(e);
}
```

Bad practice:
```java
private void saveAndCompile(ActionEvent e) {
	/*
	{
	  Code for saving
	}
	*/
	/*
	{
	  Code for compiling
	}
}
```

2. Use type inference. You're in java 21+ afterall have a little fun and use var anywhere you can. 

```java
// Ok, but can be modenized
JButton btnOk = new JButton();

// Nice
var btnOk = new JButton();
```

NOTE: Type inference deduces the type from the expression.

```java
List<String> items = new ArrayList<String>(); // Type List<String>
var items = new ArrayList<String>(); // Type ArrayList<String>
```
3. Always format your code before pushing to github. 

4. Never push to master/main branch. Submit a pull request from your branch. 

5. Always do `git pull` before doing any work.




