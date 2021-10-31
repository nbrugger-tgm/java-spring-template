# flake8: noqa

# import all models into this package
# if you have many models here with many references from one model to another this may
# raise a RecursionError
# to avoid this, import only the models that you directly need like:
# from from ProjectName.Client.model.pet import Pet
# or import this package, but before doing it, use:
# import sys
# sys.setrecursionlimit(n)

from ProjectName.Client.model.error_response import ErrorResponse
from ProjectName.Client.model.version_response import VersionResponse
