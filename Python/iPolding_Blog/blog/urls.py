__author__ = 'ian'
from django.conf.urls import patterns, url
from blog import views

urlpatterns = patterns('',
    url(r'^$', views.IndexView.as_view(), name='index'),
    url(r'^entry/(?P<pk>\d+)$', views.DetailView.as_view(), name='blog_entry'),

)