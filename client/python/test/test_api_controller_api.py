"""
    OpenAPI definition

    No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)  # noqa: E501

    The version of the OpenAPI document: v0
    Generated by: https://openapi-generator.tech
"""


import unittest

import ProjectName.Client
from ProjectName.Client.api.api_controller_api import ApiControllerApi  # noqa: E501


class TestApiControllerApi(unittest.TestCase):
    """ApiControllerApi unit test stubs"""

    def setUp(self):
        self.api = ApiControllerApi()  # noqa: E501

    def tearDown(self):
        pass

    def test_version(self):
        """Test case for version

        """
        pass


if __name__ == '__main__':
    unittest.main()
