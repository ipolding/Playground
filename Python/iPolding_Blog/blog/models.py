from django.db import models

# Create your models here.

class Entry(models.Model):
    title = models.CharField(max_length=140)
    pub_date = models.DateTimeField('date published')
    author = models.CharField(max_length=30)
    summary = models.TextField()
    text = models.TextField()

    def __unicode__(self):
        return self.title
