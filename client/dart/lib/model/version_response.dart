//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class VersionResponse {
  /// Returns a new [VersionResponse] instance.
  VersionResponse({
    this.version,
    this.stable,
  });

  String version;

  bool stable;

  @override
  bool operator ==(Object other) => identical(this, other) || other is VersionResponse &&
     other.version == version &&
     other.stable == stable;

  @override
  int get hashCode =>
  // ignore: unnecessary_parenthesis
    (version == null ? 0 : version.hashCode) +
    (stable == null ? 0 : stable.hashCode);

  @override
  String toString() => 'VersionResponse[version=$version, stable=$stable]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
    if (version != null) {
      json[r'version'] = version;
    }
    if (stable != null) {
      json[r'stable'] = stable;
    }
    return json;
  }

  /// Returns a new [VersionResponse] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static VersionResponse fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();
      return VersionResponse(
        version: mapValueOfType<String>(json, r'version'),
        stable: mapValueOfType<bool>(json, r'stable'),
      );
    }
    return null;
  }

  static List<VersionResponse> listFromJson(dynamic json, {bool emptyIsNull, bool growable,}) =>
    json is List && json.isNotEmpty
      ? json.map(VersionResponse.fromJson).toList(growable: true == growable)
      : true == emptyIsNull ? null : <VersionResponse>[];

  static Map<String, VersionResponse> mapFromJson(dynamic json) {
    final map = <String, VersionResponse>{};
    if (json is Map && json.isNotEmpty) {
      json
        .cast<String, dynamic>()
        .forEach((key, dynamic value) => map[key] = VersionResponse.fromJson(value));
    }
    return map;
  }

  // maps a json object with a list of VersionResponse-objects as value to a dart map
  static Map<String, List<VersionResponse>> mapListFromJson(dynamic json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<VersionResponse>>{};
    if (json is Map && json.isNotEmpty) {
      json
        .cast<String, dynamic>()
        .forEach((key, dynamic value) {
          map[key] = VersionResponse.listFromJson(
            value,
            emptyIsNull: emptyIsNull,
            growable: growable,
          );
        });
    }
    return map;
  }
}

