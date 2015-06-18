__author__ = 'ian'

from django.conf.urls import patterns, include, url

from abstracts import views

urlpatterns = patterns('',
    # ex: /abstracts/
    url(r'^$', views.index, name='index'),
    url(r'journals$', views.get_all_journals, name='get_all_journals'),
    # ex: /abstracts/nature/abstracts

    # ?{<name_identifying_pattern>
    url(r'^(?P<journal_title>[\s\S]+)/abstracts/$', views.get_all_abstracts_for_journal, name="abstracts_by_journal")
)


