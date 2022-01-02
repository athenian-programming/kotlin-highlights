default: versioncheck

website:
	mkdocs build --clean

serve:
	mkdocs serve

#deploy:
#	cd ../athenian-robotics.github.io; mkdocs gh-deploy --config-file ../athenian-robotics-mkdocs/mkdocs.yml --remote-branch master

clean:
	rm -rf site

refresh:
	./gradlew --refresh-dependencies

versioncheck:
	./gradlew dependencyUpdates

upgrade-wrapper:
	./gradlew wrapper --gradle-version=7.3.3 --distribution-type=bin