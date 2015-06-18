from django.db import models

# Create your models here.

class Journal(models.Model):
    journal_title = models.CharField(max_length=200)

    def __unicode__(self):
        return self.journal_title

    def is_plos_article(self):
        if 'PLOS' in self.journal_title:
            return True


class Abstract(models.Model):
    title = models.CharField(max_length=200)
    authors = models.CharField(max_length=400)
    journal = models.ForeignKey(Journal)
    volume = models.IntegerField(null=True, blank=True)
    pages = models.CharField(max_length=20, null=True, blank=True)
    date = models.DateField('date published')
    DOI = models.CharField(max_length=200)
    abstract = models.TextField(max_length=1500)

    def __unicode__(self):
        return self.title

