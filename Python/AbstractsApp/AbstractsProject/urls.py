from django.conf.urls import patterns, include, url

from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'AbstractsProject.views.home', name='home'),
    # url(r'^blog/', include('blog.urls')),

    #  include tells the python which other url files to search
    url(r'^abstracts/', include('abstracts.urls')),
    url(r'^admin/', include(admin.site.urls)),
)

